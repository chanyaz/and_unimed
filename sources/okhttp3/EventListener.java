package okhttp3;

abstract class EventListener {
    public static final EventListener a = new EventListener() {
    };

    public interface Factory {
        EventListener create(Call call);
    }

    EventListener() {
    }

    static Factory a(EventListener eventListener) {
        return new Factory() {
            public EventListener create(Call call) {
                return EventListener.this;
            }
        };
    }
}
