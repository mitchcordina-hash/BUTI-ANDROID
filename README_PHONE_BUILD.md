# BUTI Android 2.0

This is the native Android test build of BUTI.

## What changed
- BUTI runs inside a native Android app instead of relying on Chrome PWA installation.
- The budgeting data stays in the Android WebView's local storage on the device.
- Receipt camera and gallery selection are handled by Android.
- The PWA install buttons/service worker are removed from the native build.
- App version: 2.0 Android Test.

## Build the APK with GitHub
This project includes `.github/workflows/build-apk.yml`.

After the project is in a GitHub repository:
1. Open the repository.
2. Tap **Actions**.
3. Open **Build BUTI APK**.
4. Tap **Run workflow**.
5. When the build finishes, open the workflow run.
6. Download the artifact named **BUTI-Android-2.0**.
7. Unzip it on the phone and install `app-debug.apk`.

Android may ask you to allow installation from Chrome/My Files the first time.
