@extends('master')

@section('content')

@if(session('success'))
<div class="alert alert-success">
    {{ session('success') }}
</div>
@else
<div class="alert alert-error">
    {{ session('error') }}
</div>
@endif
<div class="card">
    <div class="card-header">
        <div class="row">
            <div class="col col-md-6"><b>Product Details</b></div>
            <div class="col col-md-6">
                <a href="{{ route('product.index') }}" class="btn btn-primary btn-sm float-end mx-1">View All</a>
            </div>
        </div>
    </div>

    <div class="card-body">
        <div class="row mb-3">
            <label class="col-sm-2 col-label-form"><b>Product Type</b></label>
            <div class="col-sm-10">
                {{ $product->ProductType }}
            </div>
        </div>
        <div class="row mb-3">
            <label class="col-sm-2 col-label-form"><b>Product Code</b></label>
            <div class="col-sm-10">
                {{ $product->ProductCode }}
            </div>
        </div>
        <div class="row mb-4">
            <label class="col-sm-2 col-label-form"><b>ProductName</b></label>
            <div class="col-sm-10">
                {{ $product->ProductName }}
            </div>
        </div>
        <div class="row mb-4">
            <label class="col-sm-2 col-label-form"><b>Quantity</b></label>
            <div class="col-sm-10">
                {{ $product->Quantity }}
            </div>
        </div>
        <div class="row mb-4">
            <label class="col-sm-2 col-label-form"><b>Note</b></label>
            <div class="col-sm-10">
                {{ $product->Note }}
            </div>
        </div>
    </div>
</div>

@endsection('content')