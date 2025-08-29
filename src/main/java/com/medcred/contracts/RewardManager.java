package com.medcred.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class RewardManager extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b5060405162001cfe38038062001cfe8339818101604052810190620000379190620003fb565b84600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600481905550620001166000801b846200015360201b60201c565b620001487ffbd454f36a7e1a388bd6fc3ab10d434aa4578f811acbbcf33afb1c697486313c846200015360201b60201c565b505050505062000483565b6200016582826200016960201b60201c565b5050565b6200017b82826200025a60201b60201c565b6200025657600160008084815260200190815260200160002060000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550620001fb620002c460201b60201c565b73ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45b5050565b600080600084815260200190815260200160002060000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b600033905090565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000620002fe82620002d1565b9050919050565b60006200031282620002f1565b9050919050565b620003248162000305565b81146200033057600080fd5b50565b600081519050620003448162000319565b92915050565b60006200035782620002f1565b9050919050565b62000369816200034a565b81146200037557600080fd5b50565b60008151905062000389816200035e565b92915050565b6200039a81620002f1565b8114620003a657600080fd5b50565b600081519050620003ba816200038f565b92915050565b6000819050919050565b620003d581620003c0565b8114620003e157600080fd5b50565b600081519050620003f581620003ca565b92915050565b600080600080600060a086880312156200041a5762000419620002cc565b5b60006200042a8882890162000333565b95505060206200043d8882890162000378565b94505060406200045088828901620003a9565b93505060606200046388828901620003a9565b92505060806200047688828901620003e4565b9150509295509295909350565b61186b80620004936000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c806361d027b311610097578063e3d8900711610066578063e3d8900714610297578063f0bd87cc146102b5578063f0f44260146102d3578063fc0c546a146102ef57610100565b806361d027b31461020f57806391d148541461022d578063a217fddf1461025d578063d547741f1461027b57610100565b806324bebec9116100d357806324bebec91461019d5780632f2ff15d146101b957806336568abe146101d55780634cf088d9146101f157610100565b806301ffc9a71461010557806302fb4d85146101355780631ec8bb8c14610151578063248a9ca31461016d575b600080fd5b61011f600480360381019061011a9190610f83565b61030d565b60405161012c9190610fcb565b60405180910390f35b61014f600480360381019061014a919061107a565b610387565b005b61016b6004803603810190610166919061107a565b610493565b005b610187600480360381019061018291906110f0565b6106e8565b604051610194919061112c565b60405180910390f35b6101b760048036038101906101b29190611147565b610707565b005b6101d360048036038101906101ce9190611174565b610764565b005b6101ef60048036038101906101ea9190611174565b610785565b005b6101f9610808565b6040516102069190611213565b60405180910390f35b61021761082e565b604051610224919061123d565b60405180910390f35b61024760048036038101906102429190611174565b610854565b6040516102549190610fcb565b60405180910390f35b6102656108be565b604051610272919061112c565b60405180910390f35b61029560048036038101906102909190611174565b6108c5565b005b61029f6108e6565b6040516102ac9190611267565b60405180910390f35b6102bd6108ec565b6040516102ca919061112c565b60405180910390f35b6102ed60048036038101906102e89190611282565b610910565b005b6102f7610962565b60405161030491906112d0565b60405180910390f35b60007f7965db0b000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161480610380575061037f82610988565b5b9050919050565b7ffbd454f36a7e1a388bd6fc3ab10d434aa4578f811acbbcf33afb1c697486313c6103b1816109f2565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166302fb4d8584846040518363ffffffff1660e01b815260040161040e9291906112eb565b600060405180830381600087803b15801561042857600080fd5b505af115801561043c573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff167f4ed05e9673c26d2ed44f7ef6a7f2942df0ee3b5e1e17db4b99f9dcd261a339cd836040516104869190611267565b60405180910390a2505050565b7ffbd454f36a7e1a388bd6fc3ab10d434aa4578f811acbbcf33afb1c697486313c6104bd816109f2565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663399080ec856040518263ffffffff1660e01b815260040161051a919061123d565b602060405180830381865afa158015610537573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061055b9190611329565b90506000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663817b1cd26040518163ffffffff1660e01b8152600401602060405180830381865afa1580156105cc573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906105f09190611329565b905060006105ff858484610a06565b9050600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166340c10f1987836040518363ffffffff1660e01b815260040161065e9291906112eb565b600060405180830381600087803b15801561067857600080fd5b505af115801561068c573d6000803e3d6000fd5b505050508573ffffffffffffffffffffffffffffffffffffffff167f53118bff2fb56701752f5bf54053d24fb83cec92f9f6ce664b90c38a2991caa486836040516106d8929190611356565b60405180910390a2505050505050565b6000806000838152602001908152602001600020600101549050919050565b6000801b610714816109f2565b612710821115610759576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610750906113dc565b60405180910390fd5b816004819055505050565b61076d826106e8565b610776816109f2565b6107808383610a6f565b505050565b61078d610b4f565b73ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146107fa576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107f19061146e565b60405180910390fd5b6108048282610b57565b5050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600084815260200190815260200160002060000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b6000801b81565b6108ce826106e8565b6108d7816109f2565b6108e18383610b57565b505050565b60045481565b7ffbd454f36a7e1a388bd6fc3ab10d434aa4578f811acbbcf33afb1c697486313c81565b6000801b61091d816109f2565b81600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60007f01ffc9a7000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916827bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916149050919050565b610a03816109fe610b4f565b610c38565b50565b600080831480610a165750600082145b15610a2357839050610a68565b600061271083610a3391906114bd565b6004548587610a4291906114bd565b610a4c91906114bd565b610a56919061152e565b90508085610a64919061155f565b9150505b9392505050565b610a798282610854565b610b4b57600160008084815260200190815260200160002060000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550610af0610b4f565b73ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45b5050565b600033905090565b610b618282610854565b15610c3457600080600084815260200190815260200160002060000160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550610bd9610b4f565b73ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16837ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b60405160405180910390a45b5050565b610c428282610854565b610cb957610c4f81610cbd565b610c5d8360001c6020610cea565b604051602001610c6e92919061169c565b6040516020818303038152906040526040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610cb09190611720565b60405180910390fd5b5050565b6060610ce38273ffffffffffffffffffffffffffffffffffffffff16601460ff16610cea565b9050919050565b606060006002836002610cfd91906114bd565b610d07919061155f565b67ffffffffffffffff811115610d2057610d1f611742565b5b6040519080825280601f01601f191660200182016040528015610d525781602001600182028036833780820191505090505b5090507f300000000000000000000000000000000000000000000000000000000000000081600081518110610d8a57610d89611771565b5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053507f780000000000000000000000000000000000000000000000000000000000000081600181518110610dee57610ded611771565b5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535060006001846002610e2e91906114bd565b610e38919061155f565b90505b6001811115610ed8577f3031323334353637383961626364656600000000000000000000000000000000600f861660108110610e7a57610e79611771565b5b1a60f81b828281518110610e9157610e90611771565b5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350600485901c945080610ed1906117a0565b9050610e3b565b5060008414610f1c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f1390611815565b60405180910390fd5b8091505092915050565b600080fd5b60007fffffffff0000000000000000000000000000000000000000000000000000000082169050919050565b610f6081610f2b565b8114610f6b57600080fd5b50565b600081359050610f7d81610f57565b92915050565b600060208284031215610f9957610f98610f26565b5b6000610fa784828501610f6e565b91505092915050565b60008115159050919050565b610fc581610fb0565b82525050565b6000602082019050610fe06000830184610fbc565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061101182610fe6565b9050919050565b61102181611006565b811461102c57600080fd5b50565b60008135905061103e81611018565b92915050565b6000819050919050565b61105781611044565b811461106257600080fd5b50565b6000813590506110748161104e565b92915050565b6000806040838503121561109157611090610f26565b5b600061109f8582860161102f565b92505060206110b085828601611065565b9150509250929050565b6000819050919050565b6110cd816110ba565b81146110d857600080fd5b50565b6000813590506110ea816110c4565b92915050565b60006020828403121561110657611105610f26565b5b6000611114848285016110db565b91505092915050565b611126816110ba565b82525050565b6000602082019050611141600083018461111d565b92915050565b60006020828403121561115d5761115c610f26565b5b600061116b84828501611065565b91505092915050565b6000806040838503121561118b5761118a610f26565b5b6000611199858286016110db565b92505060206111aa8582860161102f565b9150509250929050565b6000819050919050565b60006111d96111d46111cf84610fe6565b6111b4565b610fe6565b9050919050565b60006111eb826111be565b9050919050565b60006111fd826111e0565b9050919050565b61120d816111f2565b82525050565b60006020820190506112286000830184611204565b92915050565b61123781611006565b82525050565b6000602082019050611252600083018461122e565b92915050565b61126181611044565b82525050565b600060208201905061127c6000830184611258565b92915050565b60006020828403121561129857611297610f26565b5b60006112a68482850161102f565b91505092915050565b60006112ba826111e0565b9050919050565b6112ca816112af565b82525050565b60006020820190506112e560008301846112c1565b92915050565b6000604082019050611300600083018561122e565b61130d6020830184611258565b9392505050565b6000815190506113238161104e565b92915050565b60006020828403121561133f5761133e610f26565b5b600061134d84828501611314565b91505092915050565b600060408201905061136b6000830185611258565b6113786020830184611258565b9392505050565b600082825260208201905092915050565b7f6d61782031303025000000000000000000000000000000000000000000000000600082015250565b60006113c660088361137f565b91506113d182611390565b602082019050919050565b600060208201905081810360008301526113f5816113b9565b9050919050565b7f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560008201527f20726f6c657320666f722073656c660000000000000000000000000000000000602082015250565b6000611458602f8361137f565b9150611463826113fc565b604082019050919050565b600060208201905081810360008301526114878161144b565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006114c882611044565b91506114d383611044565b92508282026114e181611044565b915082820484148315176114f8576114f761148e565b5b5092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601260045260246000fd5b600061153982611044565b915061154483611044565b925082611554576115536114ff565b5b828204905092915050565b600061156a82611044565b915061157583611044565b925082820190508082111561158d5761158c61148e565b5b92915050565b600081905092915050565b7f416363657373436f6e74726f6c3a206163636f756e7420000000000000000000600082015250565b60006115d4601783611593565b91506115df8261159e565b601782019050919050565b600081519050919050565b60005b838110156116135780820151818401526020810190506115f8565b60008484015250505050565b600061162a826115ea565b6116348185611593565b93506116448185602086016115f5565b80840191505092915050565b7f206973206d697373696e6720726f6c6520000000000000000000000000000000600082015250565b6000611686601183611593565b915061169182611650565b601182019050919050565b60006116a7826115c7565b91506116b3828561161f565b91506116be82611679565b91506116ca828461161f565b91508190509392505050565b6000601f19601f8301169050919050565b60006116f2826115ea565b6116fc818561137f565b935061170c8185602086016115f5565b611715816116d6565b840191505092915050565b6000602082019050818103600083015261173a81846116e7565b905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b60006117ab82611044565b9150600082036117be576117bd61148e565b5b600182039050919050565b7f537472696e67733a20686578206c656e67746820696e73756666696369656e74600082015250565b60006117ff60208361137f565b915061180a826117c9565b602082019050919050565b6000602082019050818103600083015261182e816117f2565b905091905056fea26469706673582212203567a485c438af439d1b1ac7614e7c5a04ab4dfb006f5b1bc4ca249ec260f14264736f6c63430008130033\n";

    private static String librariesLinkedBinary;

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_DISTRIBUTOR_ROLE = "DISTRIBUTOR_ROLE";

    public static final String FUNC_DISTRIBUTEREWARD = "distributeReward";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_MAXBOOSTBPS = "maxBoostBps";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SETMAXBOOSTBPS = "setMaxBoostBps";

    public static final String FUNC_SETTREASURY = "setTreasury";

    public static final String FUNC_SLASH = "slash";

    public static final String FUNC_STAKING = "staking";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_TOKEN = "token";

    public static final String FUNC_TREASURY = "treasury";

    public static final Event REWARDDISTRIBUTED_EVENT = new Event("RewardDistributed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SLASHED_EVENT = new Event("Slashed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected RewardManager(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RewardManager(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RewardManager(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RewardManager(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<RewardDistributedEventResponse> getRewardDistributedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REWARDDISTRIBUTED_EVENT, transactionReceipt);
        ArrayList<RewardDistributedEventResponse> responses = new ArrayList<RewardDistributedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RewardDistributedEventResponse typedResponse = new RewardDistributedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.base = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.finalAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RewardDistributedEventResponse getRewardDistributedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(REWARDDISTRIBUTED_EVENT, log);
        RewardDistributedEventResponse typedResponse = new RewardDistributedEventResponse();
        typedResponse.log = log;
        typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.base = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.finalAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<RewardDistributedEventResponse> rewardDistributedEventFlowable(
            EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRewardDistributedEventFromLog(log));
    }

    public Flowable<RewardDistributedEventResponse> rewardDistributedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REWARDDISTRIBUTED_EVENT));
        return rewardDistributedEventFlowable(filter);
    }

    public static List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleAdminChangedEventResponse getRoleAdminChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
        RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleAdminChangedEventFromLog(log));
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public static List<RoleGrantedEventResponse> getRoleGrantedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleGrantedEventResponse getRoleGrantedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEGRANTED_EVENT, log);
        RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleGrantedEventFromLog(log));
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public static List<RoleRevokedEventResponse> getRoleRevokedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static RoleRevokedEventResponse getRoleRevokedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ROLEREVOKED_EVENT, log);
        RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
        typedResponse.log = log;
        typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getRoleRevokedEventFromLog(log));
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public static List<SlashedEventResponse> getSlashedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SLASHED_EVENT, transactionReceipt);
        ArrayList<SlashedEventResponse> responses = new ArrayList<SlashedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SlashedEventResponse typedResponse = new SlashedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SlashedEventResponse getSlashedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SLASHED_EVENT, log);
        SlashedEventResponse typedResponse = new SlashedEventResponse();
        typedResponse.log = log;
        typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<SlashedEventResponse> slashedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSlashedEventFromLog(log));
    }

    public Flowable<SlashedEventResponse> slashedEventFlowable(DefaultBlockParameter startBlock,
            DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SLASHED_EVENT));
        return slashedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final Function function = new Function(FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> DISTRIBUTOR_ROLE() {
        final Function function = new Function(FUNC_DISTRIBUTOR_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> distributeReward(String to,
            BigInteger baseReward) {
        final Function function = new Function(
                FUNC_DISTRIBUTEREWARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(baseReward)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getRoleAdmin(byte[] role) {
        final Function function = new Function(FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_GRANTROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(byte[] role, String account) {
        final Function function = new Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> maxBoostBps() {
        final Function function = new Function(FUNC_MAXBOOSTBPS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(byte[] role, String account) {
        final Function function = new Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setMaxBoostBps(BigInteger bps) {
        final Function function = new Function(
                FUNC_SETMAXBOOSTBPS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(bps)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setTreasury(String _t) {
        final Function function = new Function(
                FUNC_SETTREASURY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _t)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> slash(String user, BigInteger amount) {
        final Function function = new Function(
                FUNC_SLASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, user), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> staking() {
        final Function function = new Function(FUNC_STAKING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> token() {
        final Function function = new Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> treasury() {
        final Function function = new Function(FUNC_TREASURY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static RewardManager load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RewardManager load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RewardManager load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new RewardManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RewardManager load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RewardManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RewardManager> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _token, String _staking, String admin,
            String _treasury, BigInteger _maxBoostBps) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _token), 
                new org.web3j.abi.datatypes.Address(160, _staking), 
                new org.web3j.abi.datatypes.Address(160, admin), 
                new org.web3j.abi.datatypes.Address(160, _treasury), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBoostBps)));
        return deployRemoteCall(RewardManager.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<RewardManager> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _token, String _staking, String admin, String _treasury,
            BigInteger _maxBoostBps) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _token), 
                new org.web3j.abi.datatypes.Address(160, _staking), 
                new org.web3j.abi.datatypes.Address(160, admin), 
                new org.web3j.abi.datatypes.Address(160, _treasury), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBoostBps)));
        return deployRemoteCall(RewardManager.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RewardManager> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _token, String _staking, String admin,
            String _treasury, BigInteger _maxBoostBps) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _token), 
                new org.web3j.abi.datatypes.Address(160, _staking), 
                new org.web3j.abi.datatypes.Address(160, admin), 
                new org.web3j.abi.datatypes.Address(160, _treasury), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBoostBps)));
        return deployRemoteCall(RewardManager.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RewardManager> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _token, String _staking, String admin, String _treasury,
            BigInteger _maxBoostBps) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _token), 
                new org.web3j.abi.datatypes.Address(160, _staking), 
                new org.web3j.abi.datatypes.Address(160, admin), 
                new org.web3j.abi.datatypes.Address(160, _treasury), 
                new org.web3j.abi.datatypes.generated.Uint256(_maxBoostBps)));
        return deployRemoteCall(RewardManager.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class RewardDistributedEventResponse extends BaseEventResponse {
        public String user;

        public BigInteger base;

        public BigInteger finalAmount;
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class SlashedEventResponse extends BaseEventResponse {
        public String user;

        public BigInteger amount;
    }
}
