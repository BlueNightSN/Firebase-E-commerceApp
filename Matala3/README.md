# Matala3 Android Firebase E-commerce App

## Short Description
`Matala3` is an Android e-commerce demo app that supports account registration/login with Firebase Authentication and basic cart/product workflows backed by Cloud Firestore.

## What the Project Does
- Registers users and stores profile metadata (`username`, `phone`, `email`) in Firestore.
- Authenticates returning users via Firebase Auth.
- Displays a personalized home screen with user profile data.
- Loads products from a Firestore `products` collection.
- Adds products into a per-user cart subcollection with quantity tracking.
- Supports removing/decrementing products from cart.

## Technologies Used
- **Language:** Java 11
- **Platform:** Android (minSdk 24, targetSdk 34)
- **Build system:** Gradle (Kotlin DSL)
- **UI:** AndroidX Fragments, RecyclerView, Material Components
- **Navigation:** Android Navigation Component (`navgraph.xml`)
- **Backend services:** Firebase Authentication + Cloud Firestore
- **Config:** Google Services Gradle plugin + `google-services.json`

## Architecture Overview
The app uses a single-activity, multi-fragment flow:

- `MainActivity` hosts `NavHostFragment` and application shell.
- `login` fragment authenticates users and routes to registration/home.
- `register` fragment creates users in Auth and writes profile docs into Firestore.
- `home_page` fragment shows user info and cart contents, and allows logout/remove.
- `ProductListFragment` fetches product docs and writes selected items to user cart.

Data model highlights:
- `users/{uid}` stores profile fields.
- `users/{uid}/cart/{productId}` stores product + `quantity`.
- `products/{productId}` is the catalog source.

## Build and Run
### Prerequisites
- Android Studio (recent stable)
- Android SDK for API 34
- JDK 11
- Firebase project with Android app config

### Steps
1. Open `Matala3` in Android Studio.
2. Verify `app/google-services.json` belongs to your Firebase project.
3. Sync Gradle.
4. Run on emulator or physical device.

### CLI build example
From `Matala3/`:
```bash
bash ./gradlew assembleDebug
```

## Example Usage
1. Launch app (starts at login screen).
2. Tap **Register** and create an account.
3. Log in with the new credentials.
4. On the home screen, tap **Add Product**.
5. Tap a product in the product list to add/increment in cart.
6. Return home and select a cart item, then tap **Remove Product** to decrement/delete.

## Future Improvements / Roadmap
- Add image URLs and richer product metadata.
- Enforce stock constraints in cart mutations.
- Introduce repository/data layer separation and ViewModel state handling.
- Improve offline/error UX and loading indicators.
- Add instrumentation/UI tests for auth/cart flows.
- Add checkout and order persistence features.
