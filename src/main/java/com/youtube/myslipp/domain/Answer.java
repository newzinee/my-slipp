package com.youtube.myslipp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Answer extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    @JsonProperty
    private User writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
    @JsonProperty
    private Question question;

    @Lob
    @JsonProperty
    private String contents;

    public Answer() {
    }

    public Answer(User writer, Question question, String contents) {
        this.writer = writer;
        this.question = question;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Answer{" +
                super.toString() +
                ", writer=" + writer +
                ", contents='" + contents + '\'' +
                '}';
    }

    public boolean isSameWriter(final User loginUser) {
        return loginUser.equals(this.writer);
    }

}
