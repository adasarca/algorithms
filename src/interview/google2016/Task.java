/**
 * Created by Ada.Sarca
 * Date: 10/15/2018
 */
package interview.google2016;

import java.util.List;

public interface Task {
    void run();
    List<Task> getDependencies();
}
