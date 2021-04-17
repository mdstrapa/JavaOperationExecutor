public class Operation {
    int number;
    String name;
    String description;
    String command;

    public Operation(int operationNumber, String operationName, String operationDescription, String operationCommand){
        number = operationNumber;
        name = operationName;
        description = operationDescription;
        command = operationCommand;
    }

    public void showDetails(){
        System.out.println("");
        System.out.println("The operation name is " + this.name);
        System.out.println(this.description);
        System.out.println("The command is '" + this.command + "'");
    }

}
