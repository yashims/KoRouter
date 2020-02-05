Pod::Spec.new do |spec|
    spec.name                     = 'KoRouter'
    spec.version                  = '0.0.1'
    spec.homepage                 = 'https://github.com/yashims/KoRouter'
#     spec.source                   = { :git => "https://github.com/yashims/KoRouter.git", :tag => "v#{spec.version}" }
    spec.source                   = { :http => "https://github.com/yashims/KoRouter/releases/download/v#{spec.version}/#{spec.name}-#{spec.version}.zip" }

    spec.authors                  = { 'Masaya Yashiro' => 'yashims85@gmail.com' }
    spec.license                  = { :type => 'MIT', :file => 'LICENSE' }
    spec.summary                  = 'One of presentation layer routing module made by Kotlin/Native.'

    spec.static_framework         = true
#     spec.ios.vendored_frameworks  = "KoRouter/distribution/#{spec.name}.framework"
    spec.preserve_paths = "*.framework"
#     spec.preserve_path = "#{spec.name}.framework"
    spec.libraries                = "c++"

    spec.requires_arc = true
    spec.platform = :ios
    spec.ios.deployment_target = '10.0'
end
