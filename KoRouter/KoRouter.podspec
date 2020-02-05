Pod::Spec.new do |spec|
    spec.name                     = 'KoRouter'
    spec.version                  = '0.0.1'
    spec.homepage                 = 'https://github.com/yashims/KoRouter'
    spec.source                   = { :git => "https://github.com/yashims/KoRouter.git", :tag => "v#{spec.version}" }
    spec.authors                  = 'yashims85@gmail.com'
    spec.license                  = 'MIT'
    spec.summary                  = 'One of presentation layer routing module made by Kotlin/Native.'

    spec.static_framework         = true
    spec.ios.vendored_frameworks      = "distribution/#{spec.name}.framework"
    spec.libraries                = "c++"
    spec.module_name              = "#{spec.name}_umbrella"

    spec.platform = :ios
    spec.ios.deployment_target = '10.0'
            

    spec.pod_target_xcconfig = {
        'KOTLIN_TARGET[sdk=iphonesimulator*]' => 'ios_x64',
        'KOTLIN_TARGET[sdk=iphoneos*]' => 'ios_arm',
#         'KOTLIN_TARGET[sdk=watchsimulator*]' => 'watchos_x86',
#         'KOTLIN_TARGET[sdk=watchos*]' => 'watchos_arm',
#         'KOTLIN_TARGET[sdk=appletvsimulator*]' => 'tvos_x64',
#         'KOTLIN_TARGET[sdk=appletvos*]' => 'tvos_arm64',
#         'KOTLIN_TARGET[sdk=macosx*]' => 'macos_x64'
    }

    spec.script_phases = [
#         {
#             :name => 'Build KoRouter',
#             :execution_position => :before_compile,
#             :shell_path => '/bin/sh',
#             :script => <<-SCRIPT
#                 set -ev
#                 REPO_ROOT="$PODS_TARGET_SRCROOT"
#                 "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" :KoRouter:syncFramework \
#                     -Pkotlin.native.cocoapods.target=$KOTLIN_TARGET \
#                     -Pkotlin.native.cocoapods.configuration=$CONFIGURATION \
#                     -Pkotlin.native.cocoapods.cflags="$OTHER_CFLAGS" \
#                     -Pkotlin.native.cocoapods.paths.headers="$HEADER_SEARCH_PATHS" \
#                     -Pkotlin.native.cocoapods.paths.frameworks="$FRAMEWORK_SEARCH_PATHS"
#             SCRIPT
#         }
    ]
end