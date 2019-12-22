public class Main {
    public static void main(String[] args) {
        Chain luotuoChain = new Chain();

        Block block1 = new Block("转账十元", "");
        luotuoChain.addBlockToChain(block1);
        Block block2 = new Block("转账十个十元", "");
        luotuoChain.addBlockToChain(block2);
        System.out.println(luotuoChain.validateChain());
/*
        //尝试篡改这个区块链
        luotuoChain.chain.get(1).data="转账一百个十元";
        luotuoChain.chain.get(1).mine(5);
        System.out.println(luotuoChain);
        System.out.println(luotuoChain.validateChain());
*/
    }
}
