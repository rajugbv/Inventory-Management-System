@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public InventoryItem saveItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

    public InventoryItem updateItem(Long id, InventoryItem item) {
        InventoryItem existingItem = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setQuantity(item.getQuantity());
        existingItem.setLocation(item.getLocation());
        return inventoryRepository.save(existingItem);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}
