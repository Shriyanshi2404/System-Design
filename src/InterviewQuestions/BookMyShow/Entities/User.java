package InterviewQuestions.BookMyShow.Entities;

public class User {
    private final String userId;
    private final String userName;

    public User(String id, String name)
    {
        this.userId = id;
        this.userName = name;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public String getUserName()
    {
        return this.userName;
    }
}
