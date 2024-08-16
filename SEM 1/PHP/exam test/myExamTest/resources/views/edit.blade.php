@extends('master')

@section('content')

<div class="card">
    <div class="card-header">Edit Product</div>
    <div class="card-body">
        <form method="post" action="{{ route('product.update', $product->id) }}" enctype="multipart/form-data">
            @csrf
            @method('PUT')
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">Product Type</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductType" class="form-control" value="{{ $product->ProductType }}" />
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">Product Code</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductCode" class="form-control" value="{{ $product->ProductCode }}" />
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">ProductName</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductName" class="form-control" value="{{ $product->ProductName }}" />
                </div>
            </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-label-form">Quantity</label>
        <div class="col-sm-10">
            <input type="number" name="Quantity" class="form-control" value="{{ $product->Quantity }}" />
        </div>
    </div>
    <div class="row mb-3">
        <label class="col-sm-2 col-label-form">Note</label>
        <div class="col-sm-10">
            <input type="text" name="Note" class="form-control" value="{{ $product->Note }}" />
        </div>
    </div>
    <div class="text-center">
        <input type="hidden" name="hidden_id" value="{{ $product->id }}" />
        <input type="submit" class="btn btn-primary" value="Edit" />
    </div>
    </form>
</div>
</div>

@endsection('content')