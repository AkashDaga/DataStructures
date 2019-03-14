import java.util.*;
import java.util.concurrent.*;

class CaloryCalculator implements Callable<Integer>
{

    private List<Integer> numberList;

    public CaloryCalculator(List<Integer> numberList) {
        this.numberList = numberList;
        Collections.sort(this.numberList);
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        int prevTotalRun = 0;
        for(int i = numberList.size()-1; i >= 0; i--){
            sum = sum + (2 * prevTotalRun + numberList.get(i));
            prevTotalRun = prevTotalRun + numberList.get(i);
        }
        return sum;
    }
}

class SocieteGeneraleTest {
    public static void main(String args[]){
        executeProblemStatement();
    }

    public static void executeProblemStatement(){
        Scanner sc = new Scanner(System.in);
        int numberOfTest = sc.nextInt();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfTest);
        List<Future<Integer>> resultList = new ArrayList<>();
        for(int i = 1; i <= numberOfTest; i++){
            ArrayList<Integer> runningList = new ArrayList<>();
            int numberOfDays = sc.nextInt();
            for(int j = 0; j < numberOfDays ; j++){
                runningList.add(sc.nextInt());
            }

            CaloryCalculator calculator  = new CaloryCalculator(runningList);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        for(Future<Integer> future : resultList)
        {
            try
            {
                System.out.println(future.get());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}