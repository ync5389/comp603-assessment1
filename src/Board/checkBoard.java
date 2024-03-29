package Board;


public class checkBoard(List<Integer> record, List<Integer> user, List<Integer> prog, int input, String turn){
    // System.out.println(input);
    int i = 0;
    boolean copy = true;

    
    for(int r: record){
        if (r == input){
            // System.out.println(">");
            i++; 
            break;
        } else {
            // System.out.println(">");
        }
    }
    if(i > 0){
        copy = true;
    }else {
        record.add(input);
        copy = false;
        if(turn.equals("y")){
            user.add(input);
        } else  if(turn.equals("n")){
            prog.add(input);
        }
    }        
    // System.out.println(copy);
    // System.out.println(record);
    return copy;
}