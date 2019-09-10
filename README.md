# SmartShop
## วิธีใช้งาน H2 Database
- <p>เข้า url : <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a></p>
- <p>ใส่ข้อมูลตามรูป<p/>
  <div>
    <img width="50%" src="/img/h2.PNG">
  </div>

## การเรียกใช้งาน Services
- <p>URL : <a href="http://localhost:8080/products">http://localhost:8080/products</a> มี method : GET, POST, PUT, DELETE</p>
  <ul>
    <li>GET : มีไว้สำหรับเรียกข้อมูลสินค้าทั้งหมด</li>
    <li>POST : มีไว้สำหรับเพิ่มสินค้าใหม่ : Key -> (String) name, (String) description, (Double) price</li>
    <li>PUT : มีไว้สำหรับอัพเดตข้อมูลสินค้า : Path -> id ของสินค้าที่ต้องการแก้, Key -> (String) name, (String) description, (Double) price</li>
    <li>DELETE : มีไว้สำหรับลบสินค้า : Path -> id ของสินค้าที่ต้องการลบ</li>
  </ul>
- <p>URL : <a href="http://localhost:8080/orders">http://localhost:8080/orders</a> มี method : GET, POST</p>
  <ul>
    <li>GET : มีไว้สำหรับเรียกข้อมูลการสั่งซื้อทั้งหมด</li>
    <li>GET by id: มีไว้สำหรับเรียกข้อมูลการสั่งซื้ออย่างระเอียดของลูกค้า : Path -> id ของลูกค้า</li>
    <li>POST : มีไว้สำหรับเพิ่มรายการสั่งซื้อ : Key -> (String) customerId, (String) productId, (Integer) quanity</li>
  </ul>
