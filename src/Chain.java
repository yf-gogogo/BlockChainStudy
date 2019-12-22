import java.util.ArrayList;
import java.util.List;

public class Chain {
    int difficulty;
    List<Block> chain = new ArrayList<>();

    public Chain(){
        chain.add(bigBang());
        difficulty = 5;
    }

    public Block bigBang() {
        Block genesisBlock = new Block("我是祖先", "");
        genesisBlock.hash = genesisBlock.computeHash();
        return genesisBlock;
    }

    public Block getLatestBlock() {
        return chain.get(chain.size()-1);
    }

    // 添加区块到区块链上
    public void addBlockToChain(Block newBlock) {
        // data
        // 找到最近一个block的hash
        // 这个hash就是新区块的previousHash
        newBlock.previousHash = getLatestBlock().hash;
        // newBlock.hash = newBlock.computeHash();
        newBlock.mine(difficulty);
        // 这个hash 需要满足一个区块链设置的条件
        chain.add(newBlock);
    }

    //验证这个当前的区块链是否合法
    //当前的数据有没有被篡改
    //我们要验证区块的previousHash是否等于previous区块的hash
    public boolean validateChain(){
        if(chain.size()==1){
            if(chain.get(0).hash.equals(chain.get(0).computeHash())){
                return false;
            }
            return true;
        }
        // this.chain[1] 是第二个区块
        // 我们从第二个区块开始 验证
        // 验证到最后一个区块 this.chain.length -1
        for(int i = 1; i<= chain.size()-1; i++){
            Block blockToValidate = chain.get(i);
            //当前的数据有没有被篡改
            if(!blockToValidate.hash.equals(blockToValidate.computeHash())){
                System.out.println("数据篡改");
                return false;
            }
            //我们要验证区块的previousHash是否等于previous区块的hash
            Block previousBlock = chain.get(i-1);
            if(!blockToValidate.previousHash.equals(previousBlock.hash)){
                System.out.println("前后区块链接断裂");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chain{" +
                "difficulty=" + difficulty +
                ", chain=" + chain +
                '}';
    }
}
