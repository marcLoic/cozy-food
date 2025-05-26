/* eslint-disable */
import * as Router from 'expo-router';

export * from 'expo-router';

declare module 'expo-router' {
  export namespace ExpoRouter {
    export interface __routes<T extends string = string> extends Record<string, unknown> {
      StaticRoutes: `` | `/` | `/(account-pages)` | `/(auth-pages)` | `/(screens)` | `/(tabs)` | `/AccountSecurity` | `/AddNewAddress` | `/AddNewPaymentMethod` | `/AddressDetails` | `/AllProducts` | `/AppApearance` | `/AvailableVouchers` | `/CameraViewPage` | `/CancelSuccessfully` | `/Cart` | `/Checkout` | `/ChooseAddress` | `/ChooseDelivery` | `/DataAnalytics` | `/ForgotPassword` | `/HelpCenter` | `/HelpSupport` | `/Home` | `/Language` | `/LeaveReview` | `/ManageAddress` | `/MyOrder` | `/MyProfile` | `/NotificationSetting` | `/OnBoardingSlider` | `/OrderDetails` | `/PaymentMethods` | `/PlaceOrderSuccessfully` | `/PrivacyPolicy` | `/ProductDetails` | `/Profile` | `/PromosVouchers` | `/RatingReviews` | `/ResetSuccessfully` | `/ReviewPostedSuccessfully` | `/Search` | `/SignInPage` | `/SignUpPage` | `/TermsService` | `/TrackOrder` | `/VerifyOTP` | `/WishList` | `/_sitemap`;
      DynamicRoutes: never;
      DynamicRouteTemplate: never;
    }
  }
}
