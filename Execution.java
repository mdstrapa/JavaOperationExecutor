import java.time.LocalDate;

public class Execution {
    Executor executor;
    LocalDate datetime;
    Operation operation;

    public Execution(Executor executionExecutor, LocalDate executionDate, Operation executionOperation){
        executor = executionExecutor;
        datetime = executionDate;
        operation = executionOperation;
    }

    public void showDetails(){
        System.out.println("");
        System.out.println("An operation was executed by executor # " + this.executor.id);
        System.out.println("Execution details: ");
        System.out.println("- Date: " + this.datetime);
        System.out.println("- Operation Name: " + this.operation.name);
        System.out.println("- Operation Comand: " + this.operation.command);
        System.out.println("- Executor Description: " + this.executor.description);
    }

}
