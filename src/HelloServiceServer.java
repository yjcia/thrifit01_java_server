import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created with IntelliJ IDEA.
 * User: YanJun
 * Date: 15-8-3
 * Time: 下午1:21
 * To change this template use File | Settings | File Templates.
 */
public class HelloServiceServer {

    public static final int SERVER_PORT = 9009;

    public static void main(String[] as) throws TTransportException {

        //设置处理器
        TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
        // 简单的单线程服务模型,阻塞IO
        TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
        TServer.Args tArgs = new TServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        ////使用二进制协议
        tArgs.protocolFactory(new TBinaryProtocol.Factory(true, true));
        //创建服务器
        TServer server = new TSimpleServer(tArgs);
        System.out.println("HelloServer start....");
        server.serve(); // 启动服务

    }
}
