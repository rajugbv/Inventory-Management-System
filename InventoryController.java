@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryService.getAllItems();
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem item) {
        return inventoryService.saveItem(item);
    }

    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem item) {
        return inventoryService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
    }
}
