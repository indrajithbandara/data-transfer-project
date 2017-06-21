package org.dataportabilityproject.serviceProviders.google;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

/**
 * Static objects shared with all Google services.
 */
public final class GoogleStaticObjects {
    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    private static final java.io.File DATA_STORE_DIR =
            new java.io.File(System.getProperty("user.home"), ".store/google_creds");

    /** Global instance of the JSON factory. */
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public static final String APP_NAME = "Portability";

    /**
     * Global instance of the {@link DataStoreFactory}. The best practice is to make it a single
     * globally shared instance across your application.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static HttpTransport getHttpTransport() {
        return HTTP_TRANSPORT;
    }

    public static FileDataStoreFactory getDataStoreFactory() {
        return DATA_STORE_FACTORY;
    }

    private GoogleStaticObjects() {}
}