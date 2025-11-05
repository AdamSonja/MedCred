Project Overview

MedCred ensures that only authentic and verified medical information circulates in the community — powered by blockchain transparency and a reputation-based incentive system.

🧩 Core Workflow

Doctor Registration

Doctors register through the backend.

Credentials are verified and linked to their blockchain wallet.

Each doctor has an on-chain identity with a reputation score.

Post Creation with Staking

Before submitting a post, the doctor stakes a certain amount of Ether (ETH).

The post content is stored on IPFS, while metadata (author, hash, stake, timestamp) is recorded on-chain.

Verification Process

Posts are reviewed or validated by the community/DAO/oracle.

If verified as authentic, the doctor gets back:

✅ Their staked ETH

✅ A reward bonus

If found misleading or false, the stake is forfeited to the reward pool.

Reputation Management

Reputation score increases with validated posts.

Misleading posts reduce score.

Reputation influences staking requirements and visibility.

🧠 Key Features

✅ Doctor registration and verification
✅ Post creation with ETH staking
✅ Reputation-based incentives
✅ Reward + Slashing mechanism
✅ On-chain transparency, IPFS storage
✅ Built on Java Spring Boot with Web3j

⚙️ Tech Stack
Layer	Technology
Backend Framework	Spring Boot (Java 17+)
Blockchain Interaction	Web3j
Smart Contracts	Solidity (Hardhat / Remix)
Storage	IPFS (for post content)
Database	PostgreSQL / MySQL
Wallet Authentication	MetaMask / Web3j Signatures
API Format	REST APIs (JSON)
🧩 System Architecture
Doctor → Frontend (React/Angular) → Spring Boot Backend
       ↓                               ↓
Blockchain (Ethereum / Sepolia) ←→ Web3j Smart Contract Service
       ↓
     IPFS (Stores post data)

🔐 Smart Contract Modules
Contract	Purpose
DoctorRegistry.sol	Registers and verifies doctors; stores wallet–identity mapping.
MedPost.sol	Handles post creation, staking, and validation logic.
ReputationManager.sol	Maintains and updates doctors’ reputation scores.
RewardPool.sol	Manages rewards, slashing, and staking pools.
📦 Backend Structure
medcred-backend/
├── src/main/java/com/medcred/
│   ├── controller/
│   │   ├── DoctorController.java
│   │   ├── PostController.java
│   │   └── ReputationController.java
│   ├── service/
│   │   ├── DoctorService.java
│   │   ├── PostService.java
│   │   ├── Web3Service.java
│   │   └── ReputationService.java
│   ├── config/
│   │   └── Web3jConfig.java
│   ├── model/
│   │   ├── Doctor.java
│   │   ├── Post.java
│   │   └── Reputation.java
│   └── MedcredApplication.java
├── src/main/resources/
│   └── application.properties
└── README.md

🔧 Setup & Installation
1️⃣ Clone Repository
git clone https://github.com/yourusername/medcred.git
cd medcred

2️⃣ Configure Blockchain Connection

Set up .env or application.properties with:

web3.rpc.url=https://sepolia.infura.io/v3/YOUR_INFURA_KEY
contract.doctorRegistry=0x123...abc
contract.medPost=0x456...def
wallet.privateKey=YOUR_PRIVATE_KEY

3️⃣ Build & Run Backend
mvn clean install
mvn spring-boot:run


Backend runs at:

http://localhost:8080

🌍 API Endpoints
Endpoint	Method	Description
/api/doctor/register	POST	Register a new doctor
/api/doctor/{id}	GET	Get doctor profile & reputation
/api/post/create	POST	Create a new post and stake ETH
/api/post/validate/{id}	PUT	Validate post authenticity
/api/reputation/{doctorId}	GET	Fetch doctor’s reputation score
🪙 Reward Logic

Stake Amount: Configurable per post (e.g., 0.05 ETH)

Reward: Stake + 5–10% bonus from pool for verified posts

Penalty: Stake forfeited if post invalid

Reputation Gain: +10 per verified post, -15 per false post

🔮 Future Enhancements

✅ DAO governance for post validation

✅ Integration with zkProofs for privacy in doctor credentials

✅ Role-based access control using smart contracts

✅ Multi-chain support (Polygon, Base, Linea)
