package com.exchange.api;

import com.exchange.enums.ApiError;

public record ApiErrorResponse(ApiError error, String data, String message) {
}
