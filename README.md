# Restaurant Management System

<div align="center">
  <img src="/Images/Logo.png" alt="Restaurant Management System Logo" />
  <br>
  <em>Modern Restaurant Management Solution Built with Java & XAMPP</em>
  <br><br>
</div>

## 📋 Overview
The Restaurant Management System is a comprehensive Java application integrated with SQL databases through XAMPP, designed to streamline restaurant operations. This system handles reservations, order management, inventory tracking, staff scheduling, and customer relationship management, all within a user-friendly interface.

---

## ✨ Features

<table>
  <tr>
    <td width="50%">
      <h3>🗓️ Reservation Management</h3>
      <p>Track and manage customer bookings with automatic table assignment</p>
    </td>
    <td width="50%">
      <h3>🧾 Order Processing</h3>
      <p>Capture and process customer orders with real-time kitchen notifications</p>
    </td>
  </tr>
  <tr>
    <td width="50%">
      <h3>📦 Inventory Control</h3>
      <p>Monitor stock levels with automatic alerts for reordering</p>
    </td>
    <td width="50%">
      <h3>👥 Staff Management</h3>
      <p>Schedule employee shifts and track performance metrics</p>
    </td>
  </tr>
  <tr>
    <td width="50%">
      <h3>👤 Customer Database</h3>
      <p>Store customer preferences and order history</p>
    </td>
    <td width="50%">
      <h3>💳 Billing and Payments</h3>
      <p>Process various payment methods and generate receipts</p>
    </td>
  </tr>
  <tr>
    <td width="50%">
      <h3>📊 Reporting</h3>
      <p>Generate detailed sales, inventory, and performance reports</p>
    </td>
    <td width="50%">
      <h3>🔐 User Authentication</h3>
      <p>Role-based access control for staff members</p>
    </td>
  </tr>
</table>

---

## 🛠️ Technical Specifications

<div align="center">
  <table>
    <tr>
      <th>Component</th>
      <th>Technology</th>
    </tr>
    <tr>
      <td>Backend</td>
      <td>Java 17</td>
    </tr>
    <tr>
      <td>Database</td>
      <td>MySQL via XAMPP</td>
    </tr>
    <tr>
      <td>Web Server</td>
      <td>Apache via XAMPP</td>
    </tr>
    <tr>
      <td>Architecture</td>
      <td>MVC (Model-View-Controller)</td>
    </tr>
    <tr>
      <td>Data Access</td>
      <td>JDBC for database operations</td>
    </tr>
    <tr>
      <td>User Interface</td>
      <td>JavaFX</td>
    </tr>
  </table>
</div>

---

## 💻 System Requirements

- Java Runtime Environment (JRE) 17 or later
- XAMPP 8.0 or later (includes Apache, MySQL, PHP)
- Minimum 4GB RAM
- 1GB available disk space

---

## 📥 Installation

1. Install XAMPP from [https://www.apachefriends.org/](https://www.apachefriends.org/)
2. Start Apache and MySQL services in XAMPP Control Panel
3. Clone the repository or download the latest release
4. Import the database schema through phpMyAdmin:
   - Open phpMyAdmin at http://localhost/phpmyadmin
   - Create a new database named `restaurant_db`
   - Import the schema from `database/schema.sql`
5. Configure database connection in `config/database.properties`
6. Run the application using `java -jar restaurant-management-system.jar`

---

## ⚙️ XAMPP Configuration

1. Ensure Apache and MySQL services are running in XAMPP Control Panel
2. Default database connection settings:
   - Host: localhost
   - Port: 3306
   - Username: root
   - Password: (blank by default)
3. For security in production environments, create a dedicated MySQL user with appropriate permissions

---

## 🚀 Usage

<div align="center">
  <img src="/api/placeholder/800/350" alt="Application Screenshot" />
</div>

After installation, launch the application and log in with the default admin credentials:
- Username: admin
- Password: admin123

Please change the default password after the first login.

---

## 📚 Documentation

<div align="center">
  <table>
    <tr>
      <td align="center">
        <h3>📘 User Guide</h3>
        <p>Complete documentation for end users</p>
      </td>
      <td align="center">
        <h3>👨‍💻 Developer Guide</h3>
        <p>API documentation and architecture overview</p>
      </td>
      <td align="center">
        <h3>🔍 FAQs</h3>
        <p>Common issues and solutions</p>
      </td>
    </tr>
  </table>
</div>

---
## 🆘 Support

For technical support or feature requests, please contact:
- 📧 Email: Oussamachichaoui1236@gmail.com

---

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

<div align="center">
  <h2>⭐ Key Benefits ⭐</h2>
  <table>
    <tr>
      <td align="center">⏱️<br><b>Save Time</b></td>
      <td align="center">💰<br><b>Reduce Costs</b></td>
      <td align="center">📈<br><b>Increase Revenue</b></td>
      <td align="center">😊<br><b>Improve Customer Satisfaction</b></td>
    </tr>
  </table>
</div>

---

## 🙏 Acknowledgments

- XAMPP development team for the integrated development environment
- JavaFX community for UI components
- MySQL community for database engine
- All contributors who have dedicated their time to improve this system
