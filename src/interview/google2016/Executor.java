/**
 * Created by Ada.Sarca
 * Date: 10/15/2018
 */
package interview.google2016;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Executor {
    private List<Task> tasks;

    public Executor(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void run() {
        HashSet<Task> executed = new HashSet<Task>();
        for (Task task : this.tasks) {
            if (!executed.contains(task)) {
                this.run(task, executed);
            }
        }
    }

    private void run(Task task, HashSet<Task> executed) {
        for (Task dependency : task.getDependencies()) {
            if (!executed.contains(dependency)) {
                this.run(dependency, executed);
            }
        }
        task.run();
        executed.add(task);
    }


    public static void main(String[] args) {
        TaskImpl task0 = new TaskImpl(0);
        TaskImpl task1 = new TaskImpl(1);
        TaskImpl task2 = new TaskImpl(2);
        TaskImpl task3 = new TaskImpl(3);
        TaskImpl task4 = new TaskImpl(4);
        TaskImpl task5 = new TaskImpl(5);
        TaskImpl task6 = new TaskImpl(6);
        TaskImpl task7 = new TaskImpl(7);
        TaskImpl task8 = new TaskImpl(8);
        TaskImpl task9 = new TaskImpl(9);

        task8.addDependency(task0);
        task2.addDependency(task8);
        task3.addDependency(task2);
        task4.addDependency(task8);
        task5.addDependency(task8);
        task6.addDependency(task2);
        task7.addDependency(task8);
        task1.addDependency(task3);
        task1.addDependency(task5);
        task1.addDependency(task6);
        task1.addDependency(task7);
        task9.addDependency(task3);
        task9.addDependency(task6);

        List<Task> tasks = new LinkedList<Task>();
        tasks.add(task0);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);
        tasks.add(task9);

        Executor executor = new Executor(tasks);
        executor.run();
    }
}
