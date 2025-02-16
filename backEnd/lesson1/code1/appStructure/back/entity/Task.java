package lesson1.code1.appStructure.back.entity;

public class Task {
    private Integer taskId;
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task(Integer taskId, String name, String description) {
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
