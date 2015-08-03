import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created with IntelliJ IDEA.
 * User: YanJun
 * Date: 15-8-3
 * Time: 下午1:24
 * To change this template use File | Settings | File Templates.
 */
public class HelloServiceClient {

    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 9009;
    public static final int TIMEOUT = 30000;

    public static void main(String[] args) throws TException {
        // 设置传输通道
        TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        // 协议要和服务端一致
        //使用二进制协议
        TProtocol protocol = new TBinaryProtocol(transport);
        //创建Client
        HelloService.Client client = new HelloService.Client(protocol);
        transport.open();
        String result = client.getHelloInterface("Hello", "world");
        System.out.println("result : " + result);
        //关闭资源
        transport.close();
    }
}
