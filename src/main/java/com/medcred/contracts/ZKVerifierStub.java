package com.medcred.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.7.0.
 */
@SuppressWarnings("rawtypes")
public class ZKVerifierStub extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506102c4806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c806361c6ceef14610030575b600080fd5b61004a600480360381019061004591906101fc565b610060565b6040516100579190610273565b60405180910390f35b60006001905092915050565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6100d38261008a565b810181811067ffffffffffffffff821117156100f2576100f161009b565b5b80604052505050565b600061010561006c565b905061011182826100ca565b919050565b600067ffffffffffffffff8211156101315761013061009b565b5b61013a8261008a565b9050602081019050919050565b82818337600083830152505050565b600061016961016484610116565b6100fb565b90508281526020810184848401111561018557610184610085565b5b610190848285610147565b509392505050565b600082601f8301126101ad576101ac610080565b5b81356101bd848260208601610156565b91505092915050565b6000819050919050565b6101d9816101c6565b81146101e457600080fd5b50565b6000813590506101f6816101d0565b92915050565b6000806040838503121561021357610212610076565b5b600083013567ffffffffffffffff8111156102315761023061007b565b5b61023d85828601610198565b925050602061024e858286016101e7565b9150509250929050565b60008115159050919050565b61026d81610258565b82525050565b60006020820190506102886000830184610264565b9291505056fea264697066735822122071ad7b0d2ad092ce69e84faef0b1329a73d2d0119c1c03533c0b128e8923c97364736f6c63430008130033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_VERIFYPROOF = "verifyProof";

    @Deprecated
    protected ZKVerifierStub(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ZKVerifierStub(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ZKVerifierStub(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ZKVerifierStub(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> verifyProof(byte[] param0, BigInteger param1) {
        final Function function = new Function(FUNC_VERIFYPROOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ZKVerifierStub load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new ZKVerifierStub(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ZKVerifierStub load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ZKVerifierStub(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ZKVerifierStub load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new ZKVerifierStub(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ZKVerifierStub load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ZKVerifierStub(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ZKVerifierStub> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ZKVerifierStub.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ZKVerifierStub> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ZKVerifierStub.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<ZKVerifierStub> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ZKVerifierStub.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<ZKVerifierStub> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ZKVerifierStub.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

//    public static void linkLibraries(List<Contract.LinkReference> references) {
//        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
//    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
