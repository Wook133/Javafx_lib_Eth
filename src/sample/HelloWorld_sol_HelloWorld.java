package sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class HelloWorld_sol_HelloWorld extends Contract {
    private static final String BINARY = "6080604052600560005534801561001557600080fd5b5060ea806100246000396000f30060806040526004361060525763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416634f2be91f811460575780636deebae314606b5780638ada066e14607d575b600080fd5b348015606257600080fd5b50606960a1565b005b348015607657600080fd5b50606960ac565b348015608857600080fd5b50608f60b8565b60408051918252519081900360200190f35b600080546001019055565b60008054600019019055565b600054905600a165627a7a723058201681bc980619b96534425625a7d3d21672b06044d2f34ca70d12bfa1dde01bd00029";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_SUBTRACT = "subtract";

    public static final String FUNC_GETCOUNTER = "getCounter";

    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HelloWorld_sol_HelloWorld(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> add() {
        final Function function = new Function(
                FUNC_ADD,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> subtract() {
        final Function function = new Function(
                FUNC_SUBTRACT,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getCounter() {
        final Function function = new Function(FUNC_GETCOUNTER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<HelloWorld_sol_HelloWorld> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HelloWorld_sol_HelloWorld.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static HelloWorld_sol_HelloWorld load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HelloWorld_sol_HelloWorld(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
