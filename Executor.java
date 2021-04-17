import java.util.List;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Executor {
    int id;
    String description;
    
    public Executor(int executorId, String executorDescription){
        id = executorId;
        description = executorDescription;
    }
    
    public boolean executeOperation(Operation operation, List<Execution> executionLog){

        //just to simulate the operation
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        Execution newExecution = new Execution(this, LocalDate.now(), operation);
        executionLog.add(newExecution);

        return true;
    }


}
