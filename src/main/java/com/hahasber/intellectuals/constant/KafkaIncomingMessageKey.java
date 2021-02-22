package com.hahasber.intellectuals.constant;

public enum KafkaIncomingMessageKey {
    /**
     *
     */
    IN_KEY("in_key"),
    /**
     *
     */
    CLEAR_KEY("clear_key");

    private final String text;

    KafkaIncomingMessageKey(String text) {
        this.text = text;
    }

    public static KafkaIncomingMessageKey fromString(String text) {
        for (KafkaIncomingMessageKey b : KafkaIncomingMessageKey.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unknown message key: " + text);
    }

    public String getText() {
        return this.text;
    }
}
