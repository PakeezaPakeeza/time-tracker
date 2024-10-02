package training.taylor.timetracker.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.List;
import java.util.Optional;

@Component
public class Tracker {
    @Autowired
    private List<TimeEntry> entries;

    public void add(TimeEntry entry) {
        if (entry != null) {
            entries.add(entry);
        }
    }

    public void remove(TimeEntry entry) {
        if (entry != null && entries.contains(entry)) {
            entries.remove(entry);
        }
    }

    public int size() {
        return Optional.ofNullable(entries).map(List::size).orElse(0);
    }

    public TimeEntry get(int index) {
        if (index >= 0 && index < size()) {
            return entries.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}

