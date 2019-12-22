
import utils.MDutil;


public class ProofOfWork {

    public static void main(String[] args) {
        proofOfWork();
    }

    /**
     * 工作量证明函数
     */
    public static void proofOfWork(){
        int x = 1;
        String data = "luotuo";
        while (true){
            if(!MDutil.SHA256(data+x).substring(0,1).equals("0")){
                x++;
            }else {
                System.out.println("计算"+x+"次");
                System.out.println(MDutil.SHA256(data+x));
                break;
            }
        }
    }
}
