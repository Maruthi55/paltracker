package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    List<TimeEntry> timeEntries = new ArrayList<>();

    @Override
    public TimeEntry create(TimeEntry entry) {
        entry.setId(timeEntries.size() + 1);
        timeEntries.add(entry);
        return entry;

    }

    @Override
    public TimeEntry find(Long id) {
        for (TimeEntry entry : timeEntries) {
            if (entry.getId() == id)
                return entry;
        }
        return null;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry entry) {
        for (int i = 0; i < timeEntries.size(); i++) {
            if (timeEntries.get(i).getId() == id) {
                entry.setId(id);
                timeEntries.set(i, entry);
                return entry;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Iterator<TimeEntry> it = timeEntries.listIterator();
        while (it.hasNext()) {
            TimeEntry te = it.next();
            if (te.getId() == id) {
                it.remove();
            }
        }
    }
}