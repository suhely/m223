package ch.zli.m223.punchclock.controller;
/**
 * EntryController handles Training Mapping
 * It calls functions from the "Entryservice" to execute the fitting action
 *
 */

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    /**
     * The method "getAllEntries" gets all training entries the athlete has
     * created so far.
     * @return entryService.findAll
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries() {
        return entryService.findAll();
    }


    /**
     * The method "createEntry" is called whenever an athlete likes to
     * create a new training. It uses following parameters:
     * @param entry
     * @param principal
     *
     * and returns the following:
     * @return entryService.createEntry(entry)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry, Principal principal) {
//        entry.setUser(principal.getName());
        return entryService.createEntry(entry);
    }

    /**
     * The method "deleteEntry" is called whenever an athlete likes to
     * delete an already existing training. It uses the following parameter:
     * @param id
     * Since it deletes entries, it does not have to return anything.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable long id) {
        entryService.deleteEntry(id);
    }

    /**
     * The method "updateEntry" makes it for the athlete possible,
     * to update an already existing training.
     * It uses the following parameter:
     * @param entry
     *
     * and returns the following:
     * @return entryService.updateEntry(entry)
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry) {
        return entryService.updateEntry(entry);
    }
}
