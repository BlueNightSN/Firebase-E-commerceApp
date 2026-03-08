# App Module (`:app`)

## Short Description
The `:app` module contains the Android client implementation for authentication, product browsing, and cart management using Firebase services.

## Technologies Used
- Java + Android SDK
- AndroidX Fragment + RecyclerView
- Navigation Component
- Firebase Authentication
- Firebase Firestore

## Module Architecture
- **Entry point:** `MainActivity`
- **UI layers:** Fragment-based screens (`login`, `register`, `home_page`, `ProductListFragment`)
- **Adapters:**
  - `ProductAdapter` for product list selection
  - `CartAdapter` for cart display/selection
- **Model:** `Product`
- **Navigation:** `res/navigation/navgraph.xml`

## Build / Run
From the parent project directory (`Matala3/`):
```bash
bash ./gradlew :app:assembleDebug
```

Run the generated APK from Android Studio or install it using ADB.

## Example Usage
- Register a user account.
- Login and navigate to home.
- Open product list and tap products to add to cart.
- Back on home, select a cart item and remove/decrement it.

## Future Improvements
- Introduce ViewModels and lifecycle-aware state.
- Add dedicated cart/product item layouts with images.
- Add validation and structured error handling.
- Add UI/integration test coverage.
