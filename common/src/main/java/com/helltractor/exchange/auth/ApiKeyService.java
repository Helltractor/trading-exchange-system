package com.helltractor.exchange.auth;

import com.helltractor.exchange.model.ui.ApiKeyAuthEntity;
import com.helltractor.exchange.support.AbstractDbService;
import com.helltractor.exchange.util.HashUtil;
import com.helltractor.exchange.util.IdUtil;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ApiKeyService extends AbstractDbService {
    
    /**
     * Validate API key and signature.
     */
    public ApiKeyAuthEntity validate(String apiKey, String apiSignature) {
        String apiSecret = HashUtil.sha256(apiSignature);
        ApiKeyAuthEntity apiKeyAuthEntity = dataBase.from(ApiKeyAuthEntity.class).where("apiKey", apiKey, "apiSecret", apiSecret).first();
        return apiKeyAuthEntity;
    }
    
    /**
     * Generate API key and secret for a user.
     */
    public ApiKeyAuthEntity generate(Long userId) {
        return generate(userId, 2_700_000_000L); // default expire time 31 days
    }
    
    public ApiKeyAuthEntity generate(Long userId, Long expireTime) {
        ApiKeyAuthEntity apiKeyAuthEntity = new ApiKeyAuthEntity();
        apiKeyAuthEntity.userId = userId;
        apiKeyAuthEntity.apiKey = IdUtil.generateUniqueId();
        String apiSignature = IdUtil.generateUniqueId();
        apiKeyAuthEntity.apiSecret = HashUtil.sha256(apiSignature);
        apiKeyAuthEntity.expiresAt = System.currentTimeMillis() + expireTime; // set expiration time
        dataBase.insert(apiKeyAuthEntity);
        return apiKeyAuthEntity;
    }
    
    /**
     * Check if the API key is expired.
     */
    public boolean isExpired(ApiKeyAuthEntity apiKeyAuthEntity) {
        return apiKeyAuthEntity.expiresAt < System.currentTimeMillis();
    }
}
