/**
 * Created by Ada.Sarca
 * Date: 10/15/2018
 */
package interview.google2016;

import java.util.LinkedList;
import java.util.List;

public class TaskImpl implements Task {
    private int id;
    private List<Task> dependencies;

    public TaskImpl(int id) {
        this.id = id;
        this.dependencies = new LinkedList<>();
    }

    public void addDependency(Task task) {
        this.dependencies.add(task);
    }

    @Override
    public void run() {
        System.out.println("Running Task " + this.id);
    }

    @Override
    public List<Task> getDependencies() {
        return this.dependencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskImpl task = (TaskImpl) o;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
