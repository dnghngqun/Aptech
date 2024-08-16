@extends('master')

@section('content')

@if($errors->any())

<div class="alert alert-danger">
    <ul>
        @foreach($errors->all() as $error)

        <li>{{ $error }}</li>

        @endforeach
    </ul>
</div>

@endif

<div class="card">
    <div class="card-header">
        <span>Add Mobile</span>
        <a href="{{ route('product.index') }}" class="btn btn-primary btn-sm float-end">Back to list</a>
    </div>
    <div class="card-body">
        <form method="post" action="{{ route('product.store') }}" enctype="multipart/form-data">
            @csrf
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">Product Type</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductType" class="form-control" />
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">Product Code</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductCode" class="form-control" />
                </div>
            </div>
            <div class="row mb-4">
                <label class="col-sm-2 col-label-form">Product Name</label>
                <div class="col-sm-10">
                    <input type="text" name="ProductName" class="form-control" />
                </div>
            </div>
            <div class="row mb-4">
                <label class="col-sm-2 col-label-form">Quantity</label>
                <div class="col-sm-10">
                    <input type="number" name="Quantity" />
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-2 col-label-form">Note</label>
                <div class="col-sm-10">
                    <input type="text" name="Note" class="form-control" />
                </div>
            </div>
            <div class="text-center">
                <input type="submit" class="btn btn-primary" value="Add" />
            </div>
        </form>
    </div>
</div>

@endsection('content')