package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments;

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comments = new ArrayList<>();
    }

    public Issue(Issue otherIssue, CopyMode copyMode) {
        this.name = otherIssue.name;
        this.time = otherIssue.time;
        this.status = otherIssue.status;
        this.comments = (copyMode == CopyMode.WITH_COMMENTS) ? copyCommentsFrom(otherIssue) : new ArrayList<>();
    }

    private List<Comment> copyCommentsFrom(Issue issue) {
        List<Comment> commentsCopy = new ArrayList<>();
        for (Comment otherComment : issue.comments) {
            commentsCopy.add(new Comment(otherComment));
        }
        return commentsCopy;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
}
