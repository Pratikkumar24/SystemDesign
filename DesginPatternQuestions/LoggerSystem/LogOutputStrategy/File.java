package LoggerSystem.LogOutputStrategy;

public class File implements PrintInterface{
    @Override
    public void printMessage(String messString) {
        System.out.println("[File] " + messString);
    }
}
