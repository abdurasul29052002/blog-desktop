package com.example.blogdesktop.model;

import com.example.blogdesktop.model.enums.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReactionModel {
    private Long id;

    private ReactionType reactionType;

    private PostModel post;

    private UserModel user;
}
