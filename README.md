.

🚀 Project Overview

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
Backend Framework	       Spring Boot (Java 17+)
Blockchain Interaction	Web3j
Smart Contracts	       Solidity (Hardhat / Remix)
Storage	              IPFS (for post content)
Database	              PostgreSQL / MySQL
Wallet Authentication	MetaMask / Web3j Signatures
API Format	              REST APIs (JSON)

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
