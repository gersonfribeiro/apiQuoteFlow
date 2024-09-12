package com.workspacepi.apiquoteflow.adapters.http.error;

import java.util.UUID;

public class ErrorResponse {
    private UUID id;
    private String message;

    public ErrorResponse(UUID id, String message) {
        this.id = id;
        this.message = message;
    }
}
