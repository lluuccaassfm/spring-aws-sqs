package tech.lucas.sqs.controller;


import lombok.NonNull;

public record MessageDTO(
        @NonNull
        String content
) {
}
