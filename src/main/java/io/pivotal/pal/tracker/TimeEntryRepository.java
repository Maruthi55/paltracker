package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry entry);

    TimeEntry find(Long id);

    List<TimeEntry> list();

    TimeEntry update(Long id, TimeEntry entry);

    void delete(Long id);
}
