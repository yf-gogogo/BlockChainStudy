import utils.MDutil;

public class Block {
    String hash;
    String data;
    String previousHash;
    int nonce;
    public Block(String data,String previousHash){
        this.data = data;
        this.previousHash = previousHash;
    }
    public String computeHash() {
        return MDutil.SHA256(this.data + this.previousHash + this.nonce);
    }
    public String getAnswer(int difficulty) {
        //开头前n位为0的hash
        String answer = "";
        for(int i=0; i< difficulty;i++){
            answer+='0';
        }
        return answer;
    }
    //计算复合区块链难度要求的hash
    // 什么是 复合区块链难度要求的hash
    public void mine(int difficulty){
        while(true){
            hash = computeHash();
            if(!hash.substring(0,difficulty).equals(getAnswer(difficulty))){
                nonce++;
                this.hash=this.computeHash();
            }else{
                break;
            }
        }
        System.out.println("挖矿结束" + hash);
    }

    @Override
    public String toString() {
        return "Block{" +
                " hash='" + hash + '\'' +
                ", data='" + data + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
