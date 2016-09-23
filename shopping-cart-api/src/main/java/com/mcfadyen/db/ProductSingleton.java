package com.mcfadyen.db;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mcfadyen.model.Product;

/**
 * Basic singleton to simulate a Database Table with available products
 * @author Daniel Kist
 */
public class ProductSingleton {
    
	private static final ProductSingleton INSTANCE = new ProductSingleton();
	
	private static final Map<String, Product> map  = new HashMap<String, Product>();
 
    private ProductSingleton() {}
 
    public static ProductSingleton getInstance() {
    	if(map.isEmpty()) init();
        return INSTANCE;
    }
    
    private static void init() {
    	put(new Product("2034b075-eed2-4fb6-b57d-6ca6ca6eed39", "Canon EOS 5D Mark IV DSLR Camera (Body Only)", "https://static.bhphoto.com/images/images250x250/1472097112000_1274705.jpg", BigDecimal.valueOf(3499.00)));
    	put(new Product("19bf68a8-3d7e-4cde-9d8f-c60bc8d43edc", "Sony Alpha a7S II Mirrorless Digital Camera (Body Only)", "https://static.bhphoto.com/images/images250x250/1441961130000_1186034.jpg", BigDecimal.valueOf(2998.00)));
    	put(new Product("2a1d62a1-5ffe-4fe4-9e5c-eaa96b43fc27", "Canon EOS Rebel T5 DSLR Camera with 18-55mm Lens", "https://static.bhphoto.com/images/images250x250/1457393665000_1030209.jpg", BigDecimal.valueOf(399.00)));
    	put(new Product("bceb4f87-7ed0-4f39-98a2-ccb4b672123b", "Canon EOS Rebel T5 DSLR Camera with 18-55mm and 75-300mm Lenses Bundle", "https://static.bhphoto.com/images/images250x250/1427995663000_1135402.jpg", BigDecimal.valueOf(449.00)));
    	put(new Product("43e69f47-f7a3-46ad-9c73-c89d74b41953", "Fujifilm X-T2 Mirrorless Digital Camera (Body Only)", "https://static.bhphoto.com/images/images250x250/1467898846000_1263381.jpg", BigDecimal.valueOf(1599.00)));
    	put(new Product("cb502c97-4829-4048-b417-f14f3ee5fea6", "Nikon D810 DSLR Camera (Body Only)", "https://static.bhphoto.com/images/images250x250/1403765418000_1062499.jpg", BigDecimal.valueOf(2796.95)));
    	put(new Product("340002bc-b114-492f-8ef7-d082a61ffe8b", "Sony Alpha a6300 Mirrorless Digital Camera with 16-50mm Lens", "https://static.bhphoto.com/images/images250x250/1454515585000_1222773.jpg", BigDecimal.valueOf(1148.00)));
    	put(new Product("96ee80a6-f626-4c3a-9189-19d8f33907fe", "Sony Alpha a6300 Mirrorless Digital Camera (Body Only)", "https://static.bhphoto.com/images/images250x250/1454515585000_1222744.jpg", BigDecimal.valueOf(998.00)));
    	put(new Product("961b4474-041f-4001-8f4e-d85c42bab500", "Sony Cyber-shot DSC-RX100 IV Digital Camera", "https://static.bhphoto.com/images/images250x250/1452010837000_1159879.jpg", BigDecimal.valueOf(998.00)));
	}

	public static void put(Product arg0) {
    	map.put(arg0.getId(), arg0);
    }
    
    public List<Product> getAll() {
    	return map.values().stream().collect(Collectors.toList());
    }
    
    public Product get(String id) {
    	return map.get(id);
    }
    
}
