import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {


    @Override
    public String getHelloInterface(String arg1, String arg2) throws TException {
        return arg1 + "..." + arg2;  //To change body of implemented methods use File | Settings | File Templates.

    }
}