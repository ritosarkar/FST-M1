package activities;

 class CustomException extends Exception {
    private String message;
    public CustomException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {

    public  static  void main(String[] args)
    {
        try{
           Activity8 activity8=new Activity8();
           activity8.exceptionTest("Will print to console");
           activity8.exceptionTest(null);
           activity8.exceptionTest("Won't execute");
          }
            catch (Exception exception){
                System.out.println("Inside catch block: "+exception.getMessage());
            }
    }
    public void exceptionTest(String message) throws CustomException {
        if(message==null)
            throw new CustomException("String value is null");
        else
            System.out.println(message);
    }
}