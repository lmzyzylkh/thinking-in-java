abstract class Event {
    private long evtTime;

    public Event(long eventTime) {
        evtTime = eventTime;
    }

    public boolean ready() {
        return System.currentTimeMillis() >= evtTime;
    }

    abstract public void action();

    abstract public String description();
}

class EventSet {
    private Event[] events = new Event[100];
    private int index = 0;
    private int next = 0;

    public void add(Event e) {
        if (index >= events.length) return; // (In real life, throw exception)
        events[index++] = e;
    }

    public Event getNext() {
        boolean looped = false;
        int start = next;
        do {
            next = (next + 1) % events.length;
            if (start == next) looped = true;
            if ((next == (start + 1) % events.length) && looped) return null;
        } while (events[next] == null);
        return events[next];
    }

    public void removeCurrent() {
        events[next] = null;
    }
}

class Controller {
    private EventSet es = new EventSet();

    public void addEvent(Event c) {
        es.add(c);
    }

    public void run() {
        Event e;
        while ((e = es.getNext()) != null) {
            if (e.ready()) {
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }
}

public class C7GreenhouseControls
        extends Controller {
    private boolean light = false;
    private boolean water = false;
    private boolean fan = false;
    private String thermostat = "Day";

    private class LightOn extends Event {
        public LightOn(long eventTime) {
            super(eventTime);
        }

        public void action() {
            light = true;
        }

        public String description() {
            return "Light is on";
        }
    }

    private class LightOff extends Event {
        public LightOff(long eventTime) {
            super(eventTime);
        }

        public void action() {
            light = false;
        }

        public String description() {
            return "Light is off";
        }
    }

    private class WaterOn extends Event {
        public WaterOn(long eventTime) {
            super(eventTime);
        }

        public void action() {
            water = true;
        }

        public String description() {
            return "Greenhouse water is on";
        }
    }

    private class WaterOff extends Event {
        public WaterOff(long eventTime) {
            super(eventTime);
        }

        public void action() {
            water = false;
        }

        public String description() {
            return "Greenhouse water is off";
        }
    }

    private class ThermostatNight extends Event {
        public ThermostatNight(long eventTime) {
            super(eventTime);
        }

        public void action() {
            thermostat = "Night";
        }

        public String description() {
            return "Thermostat on night setting";
        }
    }

    private class ThermostatDay extends Event {
        public ThermostatDay(long eventTime) {
            super(eventTime);
        }

        public void action() {
            thermostat = "Day";
        }

        public String description() {
            return "Thermostat on day setting";
        }
    }

    // new code
    private class FanOn extends Event {
        public FanOn(long eventTime) {
            super(eventTime);
        }

        public void action() {
            fan = true;
        }

        public String description() {
            return "Fan is on";
        }
    }

    private class FanOff extends Event {
        public FanOff(long eventTime) {
            super(eventTime);
        }

        public void action() {
            fan = false;
        }

        public String description() {
            return "Fan is off";
        }
    }

    private int rings;

    private class Bell extends Event {
        public Bell(long eventTime) {
            super(eventTime);
        }

        public void action() {
            System.out.println("Bing!");
            if (--rings > 0) addEvent(new Bell(System.currentTimeMillis() + 2000));
        }

        public String description() {
            return "Ring bell";
        }
    }

    private class Restart extends Event {
        public Restart(long eventTime) {
            super(eventTime);
        }

        public void action() {
            long tm = System.currentTimeMillis();
            rings = 5;
            addEvent(new ThermostatNight(tm));
            addEvent(new LightOn(tm + 1000));
            addEvent(new LightOff(tm + 2000));
            addEvent(new WaterOn(tm + 3000));
            addEvent(new WaterOff(tm + 8000));
            addEvent(new FanOn(tm + 1000)); // 注意运行结果，FanOn，FanOff的ready时间其实比LightOff更早
            addEvent(new FanOff(tm + 1000));
            addEvent(new Bell(tm + 9000));
            addEvent(new ThermostatDay(tm + 10000));
            //addEvent(new Restart(tm + 20000));
        }

        public String description() {
            return "Restarting system";
        }
    }

    public static void main(String[] args) {
        C7GreenhouseControls gc = new C7GreenhouseControls();
        long tm = System.currentTimeMillis();
        gc.addEvent(gc.new Restart(tm));
        gc.run();
    }
}
