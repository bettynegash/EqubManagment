# Equb Management System (EMS)

A professional, Java-based console application designed to digitize and automate traditional Ethiopian *Equb* (ዕቁብ) financial crowd-saving circles. 

The system transforms manual, paper-based Equb processes into a secure digital platform where members can register, contribute capital, track financial ledgers, and participate in fair, automated lottery-based pool distributions. The architecture is engineered using robust Object-Oriented Programming (OOP) principles, modular service layers, and persistent relational storage via MySQL through the JDBC API.

---

## 👥 Project Team Work Classification

To establish an organized development lifecycle and simulate an enterprise environment, project responsibilities were decoupled into three distinct engineering tracks:

### 1. Frontend / User Interface Development
Manages the application's presentation tier, handling terminal rendering, console UI flows, user input pipelines, and multi-role view state routing.
* **Core Responsibilities:** Console menu design, session navigation paths, interactive input capturing, and data presentation.
* **Key Modules:** `Main.java`, `Login.java`, `Menu.java`, `CollectorMenu.java`

### 2. Backend / Business Logic Development
Drives the core domain rules of the application, managing object state lifecycle mutations, transaction limits, and the algorithmic draw engine.
* **Core Responsibilities:** OOP modeling, data encapsulation, contribution balance updates, tier validation compliance, and random winner selection logic.
* **Key Modules:** `Person.java`, `User.java`, `Member.java`, `Collector.java`, `Payment.java`, `MemberService.java`, `PaymentService.java`, `Equb.java`

### 3. Database Development
Architects the persistent data storage layer, optimizing transactional integrity and maintaining safe connection states between the JVM and the database engine.
* **Core Responsibilities:** Relational schema design, writing secure parameterized SQL operations, and lifecycle management of JDBC connections.
* **Key Modules:** `DBconnection.java` (Database instance: `equb_db`)

---

## 💎 Technical Highlights & Unique Features

### 1. Dual-Layer Data Validation System
To guarantee strict data integrity and prevent system corruption, the codebase implements a two-tiered validation workflow:
* **Runtime Validation Layer:** Instantly scans active heap memory through service references during an insertion request to block duplicate registration attempts or active ID collisions on the fly.
* **Database Validation Layer:** Concurrently issues a targeted JDBC statement (`SELECT id FROM members WHERE id = ?`) directly to the relational engine to double-check persistent database state records before writing data.

### 2. National ID Security System
To mitigate financial default risks inherent in traditional informal saving circles, the platform binds real-world identity metrics to member records. Capturing a member's **National ID** and **Nationality**:
* Establishes a non-repudiation framework preventing fraudulent registration.
* Eliminates the risk of a member collecting the full rotation pool and defaulting/disappearing from subsequent contribution rounds.
* Increases community trust by transparently linking identity strings to operational financial ledgers.

### 3. Tiered Equb Governance Model
The platform natively accommodates multiple sub-tier Equb types, programmatically enforcing strict financial thresholds and custom parameters depending on user categories:
* **Student Equb:** Configured with a lower financial entry barrier (**Minimum 100 Birr**). Tailored for student budgets, beginners, or small collaborative savings groups.
* **Worker Equb:** Configured for steady, formal employment cycles (**Minimum 100 Birr**). Tailored for salaried professional peer groups.
* **Merchant Equb:** Enforces high-yield transaction rules (**Minimum 1000 Birr**). Tailored for business operators, traders, and high-capital commercial cycles.

### 4. Algorithmic Lottery Pool Distribution
Automates the traditional physical drawing mechanism via a fair, pseudo-random algorithmic sequence inside `Equb.java`:
* Dynamically filters the active participant matrix to build an "eligible-only" drawing sub-pool.
* Ensures a fair distribution of wealth by automatically checking statuses and blocking past rotation winners from re-entering active draws.
* Seamlessly aggregates current group balances to compute and award total rolling prize pools instantly.

---

## 🏛️ System Class Architecture

The complete system architecture utilizes 13 core modules working in harmony:

### Execution Layer
* **`Main.java`**: The top-level system router. Initializes dependencies, spins up service environments, and controls the main session engine loop.
* **`Login.java`**: Implements authentication scopes, parsing role-based logins to unlock administrative or collector capabilities.

### OOP Model Layer
* **`Person.java`**: The root abstract class enforcing private encapsulation rules for generic human attributes (`id`, `name`, `phone`).
* **`User.java`**: Base model mapping foundational system access privileges and user-credential states.
* **`Member.java`**: Sub-class extending `Person`. Encapsulates specific domain metadata (`nationalId`, `nationality`, `totalContribution`, `winner`, `prizeWon`).
* **`Collector.java`**: Sub-class extending `User`. Maps physical collection agents interacting with systemic payment pipelines.
* **`Payment.java`**: Domain model representing a single financial record (`paymentId`, `memberId`, `amount`, `date`), offering overloaded constructors for quick runtime parsing.

### Business Logic Layer
* **`MemberService.java`**: Manages the running active state of registry data, driving searches, runtime lookups, and bootstrapping the database records on initialization.
* **`PaymentService.java`**: The balance ledger compiler. Validates entry amounts, commits payment objects to logs, and recalculates dynamic cumulative contribution values.
* **`Equb.java`**: The microfinance engine holding pool metrics, managing the drawing matrix array, and calculating total rotation payouts.

### Database & View Interface Layer
* **`DBconnection.java`**: The core Data Access Layer (DAL). Configures connection string attributes and compiles raw relational queries via secure `PreparedStatement` routines.
* **`Menu.java`**: Interface controller rendering the master Admin Dashboard and personal Member Status queries.
* **`CollectorMenu.java`**: Dedicated field interface rendering specialized ledger tools and tier-limit validation checks for collection agents.

---

## 🗄️ Database Design

Execute the following script inside your MySQL instances to spin up the persistent backplane:

```sql
CREATE DATABASE IF NOT EXISTS equb_db;
USE equb_db;

CREATE TABLE members (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    national_id VARCHAR(50),
    nationality VARCHAR(50),
    equb_type VARCHAR(20) DEFAULT 'Student',
    total_contribution DOUBLE DEFAULT 0.0,
    winner BOOLEAN DEFAULT FALSE,
    prize_won DOUBLE DEFAULT 0.0
);
### To run the full 13-class system directly from your terminal using native Java compiler flags:

# 1. Compile all  files into a binary folder while linking the JDBC driver
javac -cp "lib/*" -d bin *.java

# 2. Run the compiled Main bytecode entry point (Windows)
java -cp "bin;lib/*" Main

# 3. Run the compiled Main bytecode entry point (macOS/Linux)
java -cp "bin:lib/*" Main

## Project Structure Note

All Java source files are located in the main project directory.
The bin folder stores compiled bytecode files generated during compilation.
The lib folder contains the MySQL JDBC driver required for database connectivity.

System Access Demo Credentials;

Administrative Access Console: Username: admin | Password: 1234

Field Collector Access Console: Username: collector | Password: 1234