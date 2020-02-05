#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class KoRouterKoRouterChildrenBuilder, KoRouterRoute, KoRouterKoRouterRouteBuilder, KoRouterRouterMatchResult, KoRouterKotlinThrowable, KoRouterKotlinArray, KoRouterKotlinException;

@protocol KoRouterPresenter, KoRouterKotlinCoroutineContext, KoRouterKotlinSuspendFunction1, KoRouterKotlinIterator, KoRouterKotlinCoroutineContextElement, KoRouterKotlinCoroutineContextKey, KoRouterKotlinFunction;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wnullability"

@interface KotlinBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end;

@interface KotlinBase (KotlinBaseCopying) <NSCopying>
@end;

__attribute__((objc_runtime_name("KotlinMutableSet")))
__attribute__((swift_name("KotlinMutableSet")))
@interface KoRouterMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end;

__attribute__((objc_runtime_name("KotlinMutableDictionary")))
__attribute__((swift_name("KotlinMutableDictionary")))
@interface KoRouterMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end;

@interface NSError (NSErrorKotlinException)
@property (readonly) id _Nullable kotlinException;
@end;

__attribute__((objc_runtime_name("KotlinNumber")))
__attribute__((swift_name("KotlinNumber")))
@interface KoRouterNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end;

__attribute__((objc_runtime_name("KotlinByte")))
__attribute__((swift_name("KotlinByte")))
@interface KoRouterByte : KoRouterNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end;

__attribute__((objc_runtime_name("KotlinUByte")))
__attribute__((swift_name("KotlinUByte")))
@interface KoRouterUByte : KoRouterNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end;

__attribute__((objc_runtime_name("KotlinShort")))
__attribute__((swift_name("KotlinShort")))
@interface KoRouterShort : KoRouterNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end;

__attribute__((objc_runtime_name("KotlinUShort")))
__attribute__((swift_name("KotlinUShort")))
@interface KoRouterUShort : KoRouterNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end;

__attribute__((objc_runtime_name("KotlinInt")))
__attribute__((swift_name("KotlinInt")))
@interface KoRouterInt : KoRouterNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end;

__attribute__((objc_runtime_name("KotlinUInt")))
__attribute__((swift_name("KotlinUInt")))
@interface KoRouterUInt : KoRouterNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end;

__attribute__((objc_runtime_name("KotlinLong")))
__attribute__((swift_name("KotlinLong")))
@interface KoRouterLong : KoRouterNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end;

__attribute__((objc_runtime_name("KotlinULong")))
__attribute__((swift_name("KotlinULong")))
@interface KoRouterULong : KoRouterNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end;

__attribute__((objc_runtime_name("KotlinFloat")))
__attribute__((swift_name("KotlinFloat")))
@interface KoRouterFloat : KoRouterNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end;

__attribute__((objc_runtime_name("KotlinDouble")))
__attribute__((swift_name("KotlinDouble")))
@interface KoRouterDouble : KoRouterNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end;

__attribute__((objc_runtime_name("KotlinBoolean")))
__attribute__((swift_name("KotlinBoolean")))
@interface KoRouterBoolean : KoRouterNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("History")))
@interface KoRouterHistory : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)backNumber:(int32_t)number __attribute__((swift_name("back(number:)")));
- (NSString *)forwardNumber:(int32_t)number __attribute__((swift_name("forward(number:)")));
- (NSString *)goNumber:(int32_t)number __attribute__((swift_name("go(number:)")));
- (BOOL)hasBack __attribute__((swift_name("hasBack()")));
- (BOOL)hasForward __attribute__((swift_name("hasForward()")));
- (NSString *)pushLocation:(NSString *)location __attribute__((swift_name("push(location:)")));
- (NSString *)replaceLocation:(NSString *)location __attribute__((swift_name("replace(location:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter")))
@interface KoRouterKoRouter : KotlinBase
- (instancetype)initWithBlock:(void (^)(KoRouterKoRouterChildrenBuilder *))block __attribute__((swift_name("init(block:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithRoutes:(NSArray<KoRouterRoute *> *)routes __attribute__((swift_name("init(routes:)"))) __attribute__((objc_designated_initializer));
- (void)addChildrenParentLocation:(NSString *)parentLocation children:(NSArray<KoRouterRoute *> *)children __attribute__((swift_name("addChildren(parentLocation:children:)")));
- (void)back __attribute__((swift_name("back()")));
- (void)forward __attribute__((swift_name("forward()")));
- (void)pushLocation:(NSString *)location __attribute__((swift_name("push(location:)")));
- (void)replaceLocation:(NSString *)location __attribute__((swift_name("replace(location:)")));
@property (readonly) KoRouterRoute *currentRoute __attribute__((swift_name("currentRoute")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter.ChildrenBuilder")))
@interface KoRouterKoRouterChildrenBuilder : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSMutableArray<KoRouterRoute *> *)build __attribute__((swift_name("build()")));
- (void)routePath:(NSString *)path cb:(void (^)(KoRouterKoRouterRouteBuilder *))cb __attribute__((swift_name("route(path:cb:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter.ChildrenBuilderCompanion")))
@interface KoRouterKoRouterChildrenBuilderCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (KoRouterKoRouterChildrenBuilder *)invokeCb:(void (^)(KoRouterKoRouterChildrenBuilder *))cb __attribute__((swift_name("invoke(cb:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter.Companion")))
@interface KoRouterKoRouterCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (void)chant __attribute__((swift_name("chant()")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter.RouteBuilder")))
@interface KoRouterKoRouterRouteBuilder : KotlinBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (KoRouterRoute *)build __attribute__((swift_name("build()")));
- (void)childrenCb:(void (^)(KoRouterKoRouterChildrenBuilder *))cb __attribute__((swift_name("children(cb:)")));
@property id<KoRouterPresenter> component __attribute__((swift_name("component")));
@property NSString *name __attribute__((swift_name("name")));
@property NSString *path __attribute__((swift_name("path")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KoRouter.RouteBuilderCompanion")))
@interface KoRouterKoRouterRouteBuilderCompanion : KotlinBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
- (KoRouterKoRouterRouteBuilder *)invokePath:(NSString *)path cb:(void (^)(KoRouterKoRouterRouteBuilder *))cb __attribute__((swift_name("invoke(path:cb:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Matcher")))
@interface KoRouterMatcher : KotlinBase
- (instancetype)initWithRoutes:(NSArray<KoRouterRoute *> *)routes __attribute__((swift_name("init(routes:)"))) __attribute__((objc_designated_initializer));
- (void)addChildrenParent:(KoRouterRoute *)parent children:(NSArray<KoRouterRoute *> *)children replace:(BOOL)replace __attribute__((swift_name("addChildren(parent:children:replace:)")));
- (void)addChildrenParentLocation:(NSString *)parentLocation children:(NSArray<KoRouterRoute *> *)children __attribute__((swift_name("addChildren(parentLocation:children:)")));
- (KoRouterRouterMatchResult *)matchLocation:(NSString *)location route:(KoRouterRoute *)route __attribute__((swift_name("match(location:route:)")));
- (KoRouterRoute *)root __attribute__((swift_name("root()")));
@end;

__attribute__((swift_name("KotlinThrowable")))
@interface KoRouterKotlinThrowable : KotlinBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (KoRouterKotlinArray *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) KoRouterKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
@end;

__attribute__((swift_name("KotlinException")))
@interface KoRouterKotlinException : KoRouterKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OutOfHistoryRangeException")))
@interface KoRouterOutOfHistoryRangeException : KoRouterKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@end;

__attribute__((swift_name("Presenter")))
@protocol KoRouterPresenter
@required
- (void)onSwapInChildName:(NSString * _Nullable)name child:(id<KoRouterPresenter> _Nullable)child args:(NSDictionary<NSString *, NSString *> * _Nullable)args __attribute__((swift_name("onSwapInChild(name:child:args:)")));
- (void)onSwapOutChildName:(NSString * _Nullable)name child:(id<KoRouterPresenter> _Nullable)child __attribute__((swift_name("onSwapOutChild(name:child:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Route")))
@interface KoRouterRoute : KotlinBase
- (instancetype)initWithPath:(NSString *)path name:(NSString *)name component:(id<KoRouterPresenter>)component children:(NSMutableArray<KoRouterRoute *> * _Nullable)children parent:(KoRouterRoute * _Nullable)parent __attribute__((swift_name("init(path:name:component:children:parent:)"))) __attribute__((objc_designated_initializer));
- (NSString *)component1 __attribute__((swift_name("component1()")));
- (NSString *)component2 __attribute__((swift_name("component2()")));
- (id<KoRouterPresenter>)component3 __attribute__((swift_name("component3()")));
- (NSMutableArray<KoRouterRoute *> * _Nullable)component4 __attribute__((swift_name("component4()")));
- (KoRouterRoute * _Nullable)component5 __attribute__((swift_name("component5()")));
- (KoRouterRoute *)doCopyPath:(NSString *)path name:(NSString *)name component:(id<KoRouterPresenter>)component children:(NSMutableArray<KoRouterRoute *> * _Nullable)children parent:(KoRouterRoute * _Nullable)parent __attribute__((swift_name("doCopy(path:name:component:children:parent:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSMutableArray<KoRouterRoute *> *)fullNodes __attribute__((swift_name("fullNodes()")));
- (NSString *)fullPath __attribute__((swift_name("fullPath()")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property NSMutableArray<KoRouterRoute *> * _Nullable children __attribute__((swift_name("children")));
@property (readonly) id<KoRouterPresenter> component __attribute__((swift_name("component")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property KoRouterRoute * _Nullable parent __attribute__((swift_name("parent")));
@property (readonly) NSString *path __attribute__((swift_name("path")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RouteNotMatchException")))
@interface KoRouterRouteNotMatchException : KoRouterKotlinException
- (instancetype)initWithMessage:(NSString *)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithCause:(KoRouterKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (readonly) NSString *message __attribute__((swift_name("message")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RouterMatchResult")))
@interface KoRouterRouterMatchResult : KotlinBase
- (instancetype)initWithRoute:(KoRouterRoute *)route param:(NSDictionary<NSString *, NSString *> * _Nullable)param __attribute__((swift_name("init(route:param:)"))) __attribute__((objc_designated_initializer));
- (KoRouterRoute *)component1 __attribute__((swift_name("component1()")));
- (NSDictionary<NSString *, NSString *> * _Nullable)component2 __attribute__((swift_name("component2()")));
- (KoRouterRouterMatchResult *)doCopyRoute:(KoRouterRoute *)route param:(NSDictionary<NSString *, NSString *> * _Nullable)param __attribute__((swift_name("doCopy(route:param:)")));
- (KoRouterRouterMatchResult *)doCopyParam:(NSDictionary<NSString *, NSString *> * _Nullable)param __attribute__((swift_name("doCopy(param:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSDictionary<NSString *, NSString *> * _Nullable param __attribute__((swift_name("param")));
@property (readonly) KoRouterRoute *route __attribute__((swift_name("route")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ConcurrencyKt")))
@interface KoRouterConcurrencyKt : KotlinBase
+ (id _Nullable)korouterRunBlockingContext:(id<KoRouterKotlinCoroutineContext>)context block:(id<KoRouterKotlinSuspendFunction1>)block __attribute__((swift_name("korouterRunBlocking(context:block:)")));
@end;

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface KoRouterKotlinArray : KotlinBase
+ (instancetype)arrayWithSize:(int32_t)size init:(id _Nullable (^)(KoRouterInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (id _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<KoRouterKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(id _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end;

__attribute__((swift_name("KotlinCoroutineContext")))
@protocol KoRouterKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<KoRouterKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<KoRouterKotlinCoroutineContextElement> _Nullable)getKey:(id<KoRouterKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<KoRouterKotlinCoroutineContext>)minusKeyKey:(id<KoRouterKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<KoRouterKotlinCoroutineContext>)plusContext:(id<KoRouterKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end;

__attribute__((swift_name("KotlinFunction")))
@protocol KoRouterKotlinFunction
@required
@end;

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol KoRouterKotlinSuspendFunction1 <KoRouterKotlinFunction>
@required
@end;

__attribute__((swift_name("KotlinIterator")))
@protocol KoRouterKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end;

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol KoRouterKotlinCoroutineContextElement <KoRouterKotlinCoroutineContext>
@required
@property (readonly) id<KoRouterKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end;

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol KoRouterKotlinCoroutineContextKey
@required
@end;

#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
